package org.github.zhengchalei.example.jpa;

import com.querydsl.core.annotations.QueryEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@QueryEntity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    private Long id;

    private String name;


}
