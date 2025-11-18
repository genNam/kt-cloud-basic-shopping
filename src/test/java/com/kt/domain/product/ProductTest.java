package com.kt.domain.product;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class ProductTest {

	@Test
	void 객체_생성_성공() {
		var product = new Product(
			"테스트 상품명",
			100_000L,
			10L
		);

		assertThat(product.getName()).isEqualTo("테스트 상품명");
		assertThat(product.getPrice()).isEqualTo(100_000L);
		assertThat(product.getStock()).isEqualTo(10L);

	}

	@ParameterizedTest
	@NullAndEmptySource
	void 상품_생성_실패__상품명_null_이거나_공백(String name) {
		assertThrowsExactly(IllegalArgumentException.class, () -> new Product(
			name,
			100_000L,
			10L
		));
	}

	@Test
	void 상품_생성_실패__가격이_음수() {
		assertThrowsExactly(IllegalArgumentException.class, () -> new Product(
			"테스트 상품명",
			-1L,
			10L
		));
	}

	@Test
	void 상품_생성_실패__가격이_null() {
		assertThrowsExactly(IllegalArgumentException.class, () -> new Product(
			"테스트 상품명",
			null,
			10L
		));
	}
}