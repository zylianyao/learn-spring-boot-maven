package com.coderknock.learn.repository;

import com.coderknock.learn.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 拿客
 * 网站：www.coderknock.com
 * QQ群：213732117
 * 三产 创建于 2016年10月26日 11:21:07。
 * 描述：通过JPA持久化读者
 */
public interface ReaderRepository extends JpaRepository<Reader, String> {

}
