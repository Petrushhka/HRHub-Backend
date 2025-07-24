package com.playdata.noticeservice.notice.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.playdata.noticeservice.notice.entity.Position;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoticeUpdateRequest {

    private String title;
    private String content;
    private long departmentId;
    private String attachmentUri; // JSON 배열 문자열로 S3 파일 URL을 저장
    private String position;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime scheduledAt; // 🔥 클라이언트에서 보낸 예약 발행 시간
    private boolean published = false; // 게시 여부
}
