package hello.core.member.domain.Interface;

import hello.core.member.domain.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);
}
