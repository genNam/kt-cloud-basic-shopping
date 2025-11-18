package com.kt.repository.product;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import com.kt.domain.product.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
class ProductRepositoryTest {

	@Autowired
	private ProductRepository productRepository;

	private Product product;

	@BeforeEach
	void setUp() {
		product = productRepository.save(
			new Product(
				"테스트 상품명",
				100_000L,
				10L
			)
		);
	}

	@Test
	void 이름으로_상품_검색() {
		var foundedProduct = productRepository.findByName("테스트 상품명");

		assertThat(foundedProduct).isPresent();

	}

}