//package com.framework.gateway;
//
//import org.hyperic.sigar.CpuInfo;
//import org.hyperic.sigar.CpuPerc;
//import org.hyperic.sigar.Sigar;
//import org.hyperic.sigar.SigarException;
//import org.junit.Test;
//
//import java.util.Arrays;
//
///**
// * TODO
// *
// * @author: FengJie
// * @date: 2019/5/22 23:33
// */
//public class SigarTest {
//
//    private static void printCpuPerc(CpuPerc cpu) {
//        System.out.println("CPU用户使用率:    " + CpuPerc.format(cpu.getUser()));// 用户使用率
//        System.out.println("CPU系统使用率:    " + CpuPerc.format(cpu.getSys()));// 系统使用率
//        System.out.println("CPU当前等待率:    " + CpuPerc.format(cpu.getWait()));// 当前等待率
//        System.out.println("CPU当前错误率:    " + CpuPerc.format(cpu.getNice()));//
//        System.out.println("CPU当前空闲率:    " + CpuPerc.format(cpu.getIdle()));// 当前空闲率
//        System.out.println("CPU总的使用率:    " + CpuPerc.format(cpu.getCombined()));// 总的使用率
//    }
//
//    @Test
//    public void cpu() throws SigarException {
//        Sigar sigar = new Sigar();
//        CpuInfo[] infos = sigar.getCpuInfoList();
//
//        double v = Arrays.stream(sigar.getCpuPercList()).mapToDouble(CpuPerc::getCombined).average().orElse(0);
//        System.out.println(v);
//        CpuPerc[] cpuList = null;
//        cpuList = sigar.getCpuPercList();
//        Double x = 0D;
//        for (int i = 0; i < infos.length; i++) {// 不管是单块CPU还是多CPU都适用
//            CpuInfo info = infos[i];
//            System.out.println("第" + (i + 1) + "块CPU信息");
//            System.out.println("CPU的总量MHz:    " + info.getMhz());// CPU的总量MHz
//            System.out.println("CPU生产商:    " + info.getVendor());// 获得CPU的卖主，如：Intel
//            System.out.println("CPU类别:    " + info.getModel());// 获得CPU的类别，如：Celeron
//            System.out.println("CPU缓存数量:    " + info.getCacheSize());// 缓冲存储器数量
//            printCpuPerc(cpuList[i]);
//            x += cpuList[i].getCombined();
//        }
//        System.out.println(x / cpuList.length);
//    }
//
//}
