package kai.chang.zhang.Jian_Zhi_Offer;

import kai.chang.zhang.Algorithm.Test;

public class Test2 {  
    static {  
        System.out.println("load outer class...");  
    }  
      
    //��̬�ڲ���  
    static class StaticInner {  
        static {  
            System.out.println("load static inner class...");  
        }  
          
        static void staticInnerMethod() {  
            System.out.println("static inner method...");  
        }  
    }  
          
    public static void main(String[] args) {  
        Test2 outer = new Test2();      //�˿����ڲ����Ƿ�Ҳ�ᱻ���أ�  
         System.out.println("===========�ָ���===========");  
        Test2.StaticInner.staticInnerMethod();      //�����ڲ���ľ�̬����  
    }  
}  
