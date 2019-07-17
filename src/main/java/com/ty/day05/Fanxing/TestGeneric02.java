package com.ty.day05.Fanxing;

interface Task<Param,Result>{

    /**
     * 此方法用于执行任务
     * @param arg1 其类型由泛型参数Param决定
     * @return 其类型由泛型参数result决定
     */
    Result execute(Param arg1);
}

                            //在这里指定了 类型的话 ，在前面的 类名处不用写   ，， 实际上就是 String,Integer  作为
                                       // 实参 传入进 了 接口  的  param，result  形参 中
class TestStak implements Task<String,Integer>{

    @Override
    public Integer execute(String arg1) {
        return Integer.valueOf(arg1);
    }
}

public class TestGeneric02 {

    public static void main(String[] args) {

        TestStak task = new TestStak();

        Integer result = task.execute("2t2");

        System.out.println(result);
    }
}
