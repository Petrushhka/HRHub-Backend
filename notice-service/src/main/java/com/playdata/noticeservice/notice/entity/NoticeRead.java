package com.playdata.noticeservice.notice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "tbl_notice_read", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"notice_id", "employee_id"})
})
public class NoticeRead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeReadId;

    private Long noticeId;

    private Long employeeId;

    private LocalDateTime readAt;
}
