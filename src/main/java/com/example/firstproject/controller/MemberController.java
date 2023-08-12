package com.example.firstproject.controller;

import com.example.firstproject.dto.MemberForm;
import com.example.firstproject.entity.Member;
import com.example.firstproject.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;
    @GetMapping("/signup")
    public String signUpPage() {
        return "members/new";
    }

    @PostMapping("/join")
    public String Join(MemberForm memberForm) {
        log.info(memberForm.toString());

        // 1. DTO를 엔티티로 변환
        Member member = memberForm.toEntity();
        log.info(member.toString());

        // 2. 리파지토리로 엔티티를 DB에 저장
        Member saved = memberRepository.save(member);
        log.info(saved.toString());

        return "redirect:/members/" + saved.getId();
    }

    @GetMapping("/members/{id}")
    public String show(@PathVariable Long id, Model model) {
        // 1. id를 조회해 데이터 가져오기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        // 2. 모델에 데이터 담기
        model.addAttribute("member", memberEntity);

        // 3. 뷰로 모델 전달하기
        return "members/show";
    }

    @GetMapping("/members")
    public String index(Model model) {
        // 1. 전체 리스트를 조회에 리파지토리로 받기
        List<Member> memberList = memberRepository.findAll();

        // 2. 리스트로 받은 전체 목록을 모델에 담기
        model.addAttribute("memberList", memberList);

        // 3. 뷰페이지로 모델 전달
        return "members/index";
    }

    @GetMapping("/members/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        // 1. id값 불러와서 entity에 담기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        // 2. entity를 model에 담기
        model.addAttribute("member", memberEntity);

        // 3. 뷰페이지로 모델 전달
        return "/members/edit";
    }

    @PostMapping("/members/update")
    public String update(MemberForm form) {
        // 1. DTO를 엔티티로 변환
        Member memberEntity = form.toEntity();

        // 2. 리파지토리로 엔티티를 DB에 저장
        // 2-1. id가 db에 있는 데이터인지 확인하고 저장
        Member target = memberRepository.findById(memberEntity.getId()).orElse(null);

        if (target != null) {
            memberRepository.save(memberEntity);
        }
        /*
        if (memberEntity.getId() != null) {
            memberRepository.save(memberEntity);
        }
        */

        // 3. 상세페이지(뷰)로 리다이렉트
        return "redirect:/members/" + memberEntity.getId();
    }

    @GetMapping("/members/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr) {
        log.info("삭제요청");

        // 1. 삭제할 id 조회
        Member target = memberRepository.findById(id).orElse(null);
        log.info("삭제할 id 조회 ::::: " + target.toString());

        // 2. 해당 id가 있으면 메시지 띄우고 계정 삭제
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제 완료");
            log.info("삭제 완료 ::::: " + target.toString());
        }

        // 3. 목록 화면으로 이동
        return "/members";
    }

}
