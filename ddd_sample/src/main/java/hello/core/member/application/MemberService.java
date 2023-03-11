package hello.core.member.application;

import hello.core.member.application.Interface.MemberServiceInterface;
import hello.core.member.domain.Interface.MemberRepository;
import hello.core.member.domain.Member;
import hello.core.member.infra.MemoryMemberRepository;

public class MemberService implements MemberServiceInterface {

    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
