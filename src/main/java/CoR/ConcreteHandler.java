package CoR;

// 具体处理者
public class ConcreteHandler extends Handler {
    @Override
    public void handlerRequest(String request) {
        // 请求request满足条件
        if ("1" == request) {
            // 处理请求
        } else {
            // 转发请求
            this.successor.handlerRequest(request);
        }
    }

}
