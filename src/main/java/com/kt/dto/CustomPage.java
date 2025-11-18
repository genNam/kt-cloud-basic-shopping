package com.kt.dto;

import java.util.List;

import com.kt.domain.user.User;

// 프론트엔드에서 페이징을 구현할 때 필요한 정보

public record CustomPage(
	List<User> users,
	int size,
	int page,
	int pages,
	long totalElements
) {

}
