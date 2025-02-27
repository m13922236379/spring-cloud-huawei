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

package com.huaweicloud.swagger;

import java.util.Map;

import io.swagger.models.Swagger;
import springfox.documentation.service.Documentation;

public interface DocumentationSwaggerMapper {
  /**
   * mapping springfox schema to schema id.
   */
  default String mapSchemaId(String originalSchemaId) {
    String className = DefinitionCache.getClassNameBySchema(originalSchemaId);
    return className.replace("$", "_");
  }

  Map<String, Swagger> documentationToSwaggers(Documentation documentation);
}
