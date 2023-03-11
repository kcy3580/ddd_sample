package hello.core;

import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceInterface memberServiceInterface = applicationContext.getBean("memberServiceInterface", MemberServiceInterface.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberServiceInterface.join(member);

        Member findMember = memberServiceInterface.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
