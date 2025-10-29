package com.Practise;

public class Metaplore {
//tesco
    public static void main(String[] args) {

    }

    interface testFunction1<I extends Number, I1 extends Number, Boolean> {
        Boolean function1(Integer a, Integer b);
    }

    testFunction1<Integer,Integer,Boolean> fun1= Integer::equals;
}


/*
* Which of the following options represent valid implementation of Lambda Expressions?

1. Func<int, int, bool> testForEquality = (x, y) => x == y;

2. Func<int, int, bool> testForEquality = x, y => x == y;

3. Func<int, int> square = x => x * x;

4. Func<int, int> square = (x) => x * x;

1,3,4

*
* * * */

/*
*
* A web application is to be developed using Spring Boot that requires handling
* *  HTTP requests using RESTful API and returning a JSON response. To achieve this,
* * it should eliminate the need to annotate each method with @ResponseBody.

@PathVariable
@RequestAttribute
@RestController
@RequestMapping* */

/*
* public class ApplicationConfig {

	private DataSource dataSource;

	@Autowired

	public ApplicationConfig(DataSource dataSource) {

		this.dataSource = dataSource;

	}

	@Bean(name="clientRepository")

	ClientRepository jpaClientRepository() {

		return new JpaClientRepository();

	}

}

1. @Configuration annotation is missing

2. Default or no-arg constructor is missing

3. @Bean name is ambiguous

4. @Bean scope is prototype


 */