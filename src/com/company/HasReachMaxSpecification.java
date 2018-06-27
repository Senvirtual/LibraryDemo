package com.company;

public class HasReachMaxSpecification implements ISpecification<Member>{
    @Override
    public boolean IsSatisfied(Member member) {
        if(member.FindCurrentLongFor().size()>3){
            System.out.println("对不起，您借书数量已超过3本");
            return false;
        }else {
            System.out.println("您已经借书"+member.FindCurrentLongFor().size()+"本"+"，最多可以借3本");
            return true;}
    }
}
