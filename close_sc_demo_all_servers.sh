# 查询原有进程
echo 'sc-demo threads: '
ps -ef | grep 'java -jar ./build/libs/' | grep -Ev 'grep | close_sc_demo_all_servers.sh'

# 终止原有进程
ps -ef | grep 'java -jar ./build/libs/' | grep -Ev 'grep | close_sc_demo_all_servers.sh' | awk '{print $2}' | xargs kill -9
echo 'killing them...'
sleep 1

# 检查终止结果
echo 'sc-demo threads: '
ps -ef | grep 'java -jar ./build/libs/' | grep -Ev 'grep | close_sc_demo_all_servers.sh'
echo ''

# 分割线
echo '------------Closed------------All------------Servers------------'