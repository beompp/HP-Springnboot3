package com.example.firstproject.dto;

public class ArticleForm {
    private String title;
    private String content;

    // 제목과 내용을 필드에 저장하는 생성자 추가
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    // 데이터 수신 확인용 toString() 메소드 추가
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
