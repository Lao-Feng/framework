package com.framework.redis.config;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.ByteArrayOutputStream;

/**
 * KryoRedis系列化配置
 *
 * @Author: FengJie
 * @Date: 2019/5/8 14:37
 */
@Slf4j
public class KryoRedisSerializer<T> implements RedisSerialization<T> {

    private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];

    private static final ThreadLocal<Kryo> KRYOS = ThreadLocal.withInitial(Kryo::new);

    private Class<T> clazz;

    public KryoRedisSerializer(Class<T> clazz) {
        super();
        this.clazz = clazz;
    }

    @Override
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return EMPTY_BYTE_ARRAY;
        }

        var kryo = KRYOS.get();
        kryo.setReferences(false);
        kryo.register(clazz);

        try (var baos = new ByteArrayOutputStream();
             var output = new Output(baos)) {
            kryo.writeClassAndObject(output, t);
            output.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return EMPTY_BYTE_ARRAY;
    }

    @Override
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        Kryo kryo = KRYOS.get();
        kryo.setReferences(false);
        kryo.register(clazz);

        try (Input input = new Input(bytes)) {
            return (T) kryo.readClassAndObject(input);
        } catch (Exception e) {
            log.error("Redis缓存反序列化失败,请确定是否实现了序列化接口.", e);
        }
        return null;
    }
}