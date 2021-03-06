/*
 * Copyright 2017 Code Above Lab LLC
 *
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

package com.codeabovelab.dm.agent;

import com.codeabovelab.dm.agent.notifier.Notifier;
import com.codeabovelab.dm.agent.security.AuthConfiguration;
import com.codeabovelab.dm.agent.security.SslServletContainerCustomizer;
import com.codeabovelab.dm.agent.proxy.DockerProxyConfiguration;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.boot.autoconfigure.web.EmbeddedServletContainerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.websocket.WebSocketAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.security.Security;

/**
 */
@Import({
  PropertySourcesPlaceholderConfigurer.class,
  DockerProxyConfiguration.class,
  WebConfiguration.class
})
@EnableConfigurationProperties(ServerProperties.class)
// do not use @EnableAutoConfiguration
@Configuration
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());
        new SpringApplicationBuilder(Application.class).run(args);
    }
}
