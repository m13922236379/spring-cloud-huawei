[![Build Status](https://travis-ci.org/huaweicloud/spring-cloud-huawei.svg?branch=master)](https://travis-ci.org/huaweicloud/spring-cloud-huawei)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.huaweicloud/spring-cloud-huawei/badge.svg)](https://search.maven.org/search?q=g:com.huaweicloud%20AND%20a:spring-cloud-huawei-dependencies) 

# Spring Cloud Huawei [查看中文文档](README_CN.md)

Spring Cloud Huawei is a framework that makes it easier to integrate Spring Cloud and Huawei frameworks.
Including [Apache ServiceComb](http://servicecomb.apache.org) and [ServiceStage][ServiceStage].

## Supported version

| Branch | Spring Cloud Huawei Latest Version | Spring Cloud Version | Spring Boot Version |
| ---------- | ------------ | ----------- | ----------- |
| master | 1.9.0-2020.0.x  | 2020.0.5                 | 2.5.12                  |
| Hoxton | 1.9.0-Hoxton    | Hoxton.SR9               | 2.3.5.RELEASE           |
| Greenwich | 1.6.1-Greenwich | Greenwich.SR6 | 2.1.6-RELEASE |
| Finchley | 1.6.1-Finchley | 2.0.4.RELEASE | 2.0.9.RELEASE     |
| Edgware | 1.2.0-Edgware | 1.3.6.RELEASE  | 1.5.22.RELEASE    |

***Notice：***
* Check [Spring Cloud Release Train](https://spring.io/projects/spring-cloud), and find a proper version to use.
* Spring Cloud Edgeware, Finchley, Greenwich have all reached end of life status and are no longer supported.
* Spring Cloud Huawei Hoxton branch only implements Spring Cloud Gateway loadbalance with Ribbon, and master branch (for 2020.0.x) only implements
  Spring Cloud Gateway loadbance with Spring Cloud LoadBalance. Recommend update Spring Cloud Gateway support for 2020.0.x.

## Why use

1. Integrate Spring Cloud applications to use ServiceStage. ServiceStage is a service deployment environment for microservices,
   includes high available discovery and registration service, configuration service, governance service, transaction management
   service and so on. 
2. Integrate Spring Cloud applications to use open source [Apache ServiceComb][ServiceComb] services, like servicecomb-service-center, servicecomb-kie.
3. Other enhancements like swagger generation and registration, canary release and so on.

## Modules

 * **spring-cloud-starter-huawei-discovery:**
     * Support for use [servicecomb-service-center](https://github.com/apache/servicecomb-service-center)
     * Support for use [CSE][CSE] as [Service Registry][Service Registry]
     * Implements DiscoveryClient, ReactiveDiscoveryClient
     * Implements ServiceRegistry
     * Implements ServerList, IPing, ServerListUpdater

 * **spring-cloud-starter-huawei-config:**
     * Support for use [servicecomb-kie](https://github.com/apache/servicecomb-kie)
     * Support for use [CSE][CSE] as [Configuration Center][Configuration Center]
     * Implements PropertySource
     * Implements @RefreshScope

 * **spring-cloud-starter-huawei-governance:**
     * Support for use [CSE][CSE] [Request Marker-based Governance][Request Marker-based Governance]
     * Implements retry for FeignClient and RestTemplate
     * Implements rate limiter, circuit breaker, and bulkhead for Servlet Web MVC

 * **spring-cloud-starter-huawei-router:**
     * Support for use [ServiceStage][ServiceStage] [Canary release features][Canary release features].

 * **spring-cloud-starter-huawei-swagger:**
     * Automatically swagger document generation and registration. 

* **spring-cloud-starter-huawei-jasypt:**
     * Support for use [Profile encryption scheme][Profile encryption scheme].
     * Implements the function of identifying encryption mark in service configuration file

## How to use

1. [Developer Guide](https://support.huaweicloud.com/intl/en-us/devg-servicestage/ss-devg-0010.html)
2. [Quick Start and Samples](https://github.com/huaweicloud/spring-cloud-huawei-samples)

[ServiceStage]: https://support.huaweicloud.com/intl/en-us/productdesc-servicestage/ss_productdesc_0001.html
[CSE]: https://www.huaweicloud.com/intl/en-us/product/cse.html
[Service Registry]: https://support.huaweicloud.com/intl/en-us/devg-servicestage/ss-devg-0017.html
[Configuration Center]: https://support.huaweicloud.com/intl/en-us/devg-servicestage/ss-devg-0018.html
[Request Marker-based Governance]: https://support.huaweicloud.com/intl/en-us/devg-servicestage/ss-devg-0020.html
[Canary release features]: https://support.huaweicloud.com/devg-servicestage/ss-devg-0023.html
[ServiceComb]: http://servicecomb.apache.org/developers/
[Profile encryption scheme]: https://support.huaweicloud.com/bestpractice-cse/cse_bestpractice_0007.html
