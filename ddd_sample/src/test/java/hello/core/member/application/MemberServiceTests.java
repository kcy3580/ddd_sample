package hello.core.member.application;

import hello.core.AppConfig;
import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.domain.Grade;
import hello.core.member.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTests {

    AppConfig appConfig = new AppConfig();
    MemberServiceInterface memberServiceInterface = appConfig.memberServiceInterface();

    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberServiceInterface.join(member);
        Member findMember = memberServiceInterface.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
