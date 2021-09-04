package SpringFramework.DependencyInjection;

@Configuration
public class ConstBasedDI {

    @Bean
    public OrderService orderService() {
        return new OrderService();
    }

    @Bean
    public OrderServiceClient orderServiceClient() {
        return new OrderServiceClient(orderService());
    }

    public static void main(String... strings) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                ConstBasedDI.class);
        OrderServiceClient bean = context.getBean(OrderServiceClient.class);
        bean.showPendingOrderDetails();
    }

    private static class OrderServiceClient {

        private OrderService orderService;

        // @Autowired is not needed
        OrderServiceClient(OrderService orderService) {
            this.orderService = orderService;
        }

        public void showPendingOrderDetails() {
            System.out.println(orderService.getOrderDetails("100"));
        }
    }
}
