package com.jason;

import com.sun.tools.attach.*;

import java.io.IOException;
import java.util.List;

/**
 * 执行动更类
 * @author zhuzhenhao
 * @version 1.0.0
 * @date 2019/5/6 18:30
 */
public class HotSwap {

    public static void main(String[] args) {
        try {
            List<VirtualMachineDescriptor> list = VirtualMachine.list();
            for (VirtualMachineDescriptor vmd : list) {
                    VirtualMachine virtualMachine = null;
                    virtualMachine = VirtualMachine.attach(vmd.id());
                    // 获得代理类位置 + 传递参数
                    virtualMachine.loadAgent("E:\\agentmain.jar", "cxs");
                    virtualMachine.detach();
            }
        } catch (AttachNotSupportedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (AgentLoadException e) {
            e.printStackTrace();
        } catch (AgentInitializationException e) {
            e.printStackTrace();
        }
    }
}
