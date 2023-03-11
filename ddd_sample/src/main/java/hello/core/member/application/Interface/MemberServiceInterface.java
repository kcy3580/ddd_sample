package hello.core.member.application.Interface;

import hello.core.member.domain.Member;

public interface MemberServiceInterface {

    void join(Member member);

    Member findMember(Long memberId);
}
