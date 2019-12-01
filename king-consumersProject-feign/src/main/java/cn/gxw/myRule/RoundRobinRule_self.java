package cn.gxw.myRule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.Random;

public class RoundRobinRule_self extends AbstractLoadBalancerRule {
    Random rand = null;

    public RoundRobinRule_self() {
        rand = new Random();
    }

    /**
     * 自定义，增加新需求每个服务轮询5次
     * @param lb
     * @param key
     * @return
     */
    int total = 0;//每服务调用总数
    int currentIndex = 0;//当前服务

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers();
                List<Server> allList = lb.getAllServers();
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }
                if(total < 5){
                    server = (Server)upList.get(currentIndex);
                    total++;
                }else{
                    if(currentIndex == allList.size() - 1)
                        currentIndex = 0;
                    else
                        currentIndex++;
                    total = 0;
                }
//                int index = this.rand.nextInt(serverCount);
//                server = (Server)upList.get(index);
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
