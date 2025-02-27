/*

  * Copyright (C) 2020-2022 Huawei Technologies Co., Ltd. All rights reserved.

  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  *     http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  */

package com.huaweicloud.servicecomb.discovery;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.boot.autoconfigure.condition.AllNestedConditions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import com.huaweicloud.servicecomb.discovery.ConditionalOnServiceCombEnabled.OnServiceCombEnabledCondition;
import org.springframework.context.annotation.Conditional;

/**
 * @Author wangqijun
 * @Date 10:49 2019-07-08
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Conditional(OnServiceCombEnabledCondition.class)
public @interface ConditionalOnServiceCombEnabled {


  class OnServiceCombEnabledCondition extends AllNestedConditions {

    OnServiceCombEnabledCondition() {
      super(ConfigurationPhase.REGISTER_BEAN);
    }

    @ConditionalOnProperty(value = "spring.cloud.servicecomb.discovery.enabled",
        matchIfMissing = true)
    static class FoundProperty {

    }

    @ConditionalOnClass(OnServiceCombEnabledCondition.class)
    static class FoundClass {

    }
  }
}
