### Controller
- Controller: Nơi tiếp nhận các request tu client, xu ly va tra ve response
- @Controller: Cac controller tra ve Template(giao dien). Ngoai ra co the tra ve du lieu dang JSON, XML,...
- @RestController: Cac controller tra ve du lieu dang JSON, XML,...
- @ResponseBody: Chi tra ve du lieu ma khong tra ve Template(giao dien). Du lieu tra ve co the la JSON, XML,...
- @RestController = @Controller + @ResponseBody

- ResponseEntity<?> : Class dai dien cho 1 doi tuong response dung de tra ve du lieu, co the la status code, header,...









### BEAN là gi?
 - Duoc coi la thanh phan suong song cua Spring
 - La doi tuong duoc khoi tao, lap rap va quan ly boi Spring IoC container


### BEAN duoc tao ntn?
- Su dung cac annotations danh dau len class (class level): @Component, @Controller, @Rescontroller, @Service, @Repository
- Su dung annotations @Bean trn method (method level) trong class @Configuration



### Su dung BEAN ntn?
- Bean thuong duoc sd trong mot bean khac (dependency) 
- 3 cach sd bean:
  + Field-based-Injection(hay sd)
  + Contructor-based-Injection(hay sd)
  + Setter-based-Injection
-