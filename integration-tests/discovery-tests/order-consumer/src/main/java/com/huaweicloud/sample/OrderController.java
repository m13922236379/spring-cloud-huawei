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
package com.huaweicloud.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {

  private final DiscoveryClient discoveryClient;

  private final RestTemplate restTemplate;

  @Autowired
  public OrderController(DiscoveryClient discoveryClient, RestTemplate restTemplate) {
    this.discoveryClient = discoveryClient;
    this.restTemplate = restTemplate;
  }

  @RequestMapping("/instances")
  public Object instances() {
    return discoveryClient.getInstances("price");
  }

  @RequestMapping("/order")
  public String getOrder(@RequestParam("id") String id) {
    String callServiceResult = restTemplate.getForObject("http://price/price?id=" + id, String.class);
    return callServiceResult;
  }

  @RequestMapping("/configuration")
  public String getEnums() {
    return restTemplate.getForObject("http://price/configuration", String.class);
  }

  @RequestMapping(value = "/services", method = RequestMethod.GET)
  public Object services() {
    return discoveryClient.getServices();
  }

  @RequestMapping("/crossappinstances")
  public Object crossAppInstances() {
    return discoveryClient.getInstances("account-app.account");
  }

  @RequestMapping("/crossapporder")
  public String getCrossAppOrder(@RequestParam("id") String id) {
    return restTemplate.getForObject("http://account-app.account/account?id=" + id, String.class);
  }
}
