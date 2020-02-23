# [오류]Error occurred during initialization of boot layer



![image-20200223230837153](image\image-20200223230837153.png)

> import project 를 한 후 어플리캐이션 실행하였는데 위와 같은 오류가 발생
>
> (오류내용)  
> Error occurred during initialization of boot layer  
> java.lang.LayerInstantiationException: Package jdk.internal.jrtfs in both module java.base and module jrt.fs  



![image-20200223230933863](image\image-20200223230933863.png)

> 오류가 났던 이유는 실행 시켜야 하는 어플리캐이션이 아니라는 것..
>
> 즉,어플리캐이션이 존재하지 않는  New_configuration 을 실행시키고 있었던 것 

![image-20200223231431793](image\image-20200223231431793.png)
>Run As -> Java Application 으로 변경후 실행시키면

![image-20200223231534904](image\image-20200223231534904.png)

> 위와 같이 정상적으로 ExamProgram의 Java Application이 실행됨을 확인 할 수 있다.

