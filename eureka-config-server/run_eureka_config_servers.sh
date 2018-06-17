#!/usr/bin/env bash
# 查询原有进程
echo 'eureka-config-server threads: '
ps -ef | grep 'java -jar ./build/libs/eureka-config-server-0.0.1.jar' | grep -v 'grep'

# 终止原有进程
ps -ef | grep 'java -jar ./build/libs/eureka-config-server-0.0.1.jar' | grep -v 'grep' | awk '{print $2}' | xargs kill -9
echo 'killing them...'
sleep 1

# 检查终止结果
echo 'eureka-config-server threads: '
ps -ef | grep 'java -jar ./build/libs/eureka-config-server-0.0.1.jar' | grep -v 'grep'
echo ''

# 分割线
echo '------------Closed------------All------------Servers------------'

# 编译工程
gradle clean build

# 启动注册中心集群
nohup java -jar ./build/libs/eureka-config-server-0.0.1.jar --spring.profiles.active=peer1,native > ./build/libs/eureka_config_server_1.log 2>&1 &
nohup java -jar ./build/libs/eureka-config-server-0.0.1.jar --spring.profiles.active=peer2,native > ./build/libs/eureka_config_server_2.log 2>&1 &
tail -f ./build/libs/eureka_config_server_1.log