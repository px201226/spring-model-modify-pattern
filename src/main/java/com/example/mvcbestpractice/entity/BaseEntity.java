package com.example.mvcbestpractice.entity;

import com.example.mvcbestpractice.common.RowStatusCode;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter
@SuperBuilder(toBuilder = true)
@AllArgsConstructor @NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

	@Column(name = "ROW_STS_CD")
	@Enumerated(EnumType.STRING)
	@Setter
	protected RowStatusCode rowStsCd = RowStatusCode.U; // ROW상태코드

	@CreatedBy
	@Column(name = "REG_NO", length = 20, updatable = false)
	@Setter
	protected Long regNo = 1L; // 등록자번호

	@CreatedDate
	@Column(name = "REG_DT", nullable = false, updatable = false)
	@Setter
	protected LocalDateTime regDt; // 등록일시

	@LastModifiedBy
	@Column(name = "UPD_NO", length = 20)
	@Setter
	protected Long updNo = 1L; // 수정자번호

	@LastModifiedDate
	@Column(name = "UPD_DT")
	@Setter
	protected LocalDateTime updDt; // 수정일시
}
