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

package com.huaweicloud.governance;

import java.io.IOException;

import org.apache.servicecomb.governance.handler.ext.AbstractRetryExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpResponse;

import feign.Response;

public class SpringCloudRetryExtension extends AbstractRetryExtension {
  private static final Logger LOGGER = LoggerFactory.getLogger(SpringCloudRetryExtension.class);

  @Override
  protected String extractStatusCode(Object response) {
    int status = 0;
    if (response instanceof ClientHttpResponse) {
      try {
        status = ((ClientHttpResponse) response).getStatusCode().value();
      } catch (IOException e) {
        LOGGER.error("unexpected exception", e);
      }
    }
    if (response instanceof Response) {
      status = ((Response) response).status();
    }
    if (response instanceof Integer) {
      status = (int) response;
    }

    return String.valueOf(status);
  }
}
