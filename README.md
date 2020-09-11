# Java with RDBMS and API Intros Sprint Challenge

**Read these instructions carefully. Understand exactly what is expected _before_ starting this Sprint Challenge.**

This challenge allows you to practice the concepts and techniques learned over the past sprint and apply them in a concrete project. This sprint explored **using RDBMS and APIs in Java**. During this sprint, you studied **Spring Data, JPA, and Hibernate**. In your challenge this week, you will demonstrate your mastery of these skills by creating **a Java Spring REST API Application**.

This is an individual assessment. All work must be your own. Your challenge score is a measure of your ability to work independently using the material covered through this sprint. You need to demonstrate proficiency in the concepts and objectives introduced and practiced in preceding days.

You are not allowed to collaborate during the sprint challenge. However, you are encouraged to follow the twenty-minute rule and seek support from your TL if you need direction.

_You have **three hours** to complete this challenge. Plan your time accordingly._

## Introduction

This is a basic todo database scheme with users and a todo list. Users have a one to many relationship to todo list. One user can have many todo items while a todo item only matches to one user. CRUD operations are available to display and manipulate this data.

Your final results should look like:

### MVP

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
    {
        "userid": 1,
        "username": "admin",
        "primaryemail": "admin@lambdaschool.local",
        "todos": [
            {
                "todoid": 2,
                "description": "Give Joe access rights",
                "completed": false
            },
            {
                "todoid": 3,
                "description": "Change the color of the home page",
                "completed": false
            }
        ]
    },
    {
        "userid": 4,
        "username": "cinnamon",
        "primaryemail": "cinnamon@lambdaschool.local",
        "todos": [
            {
                "todoid": 5,
                "description": "Take a nap",
                "completed": false
            },
            {
                "todoid": 6,
                "description": "Rearrange my hutch",
                "completed": false
            },
            {
                "todoid": 7,
                "description": "Groom my fur",
                "completed": false
            }
        ]
    },
    {
        "userid": 8,
        "username": "barnbarn",
        "primaryemail": "barnbarn@lambdaschool.local",
        "todos": [
            {
                "todoid": 9,
                "description": "Rearrange my hutch",
                "completed": false
            }
        ]
    },
    {
        "userid": 10,
        "username": "puttat",
        "primaryemail": "puttat@school.lambda",
        "todos": []
    },
    {
        "userid": 11,
        "username": "misskitty",
        "primaryemail": "misskitty@school.lambda",
        "todos": []
    }
]
```

</details>

<details>
<summary>http://localhost:2019/users/user/4</summary>

```JSON
{
    "userid": 4,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "todos": [
        {
            "todoid": 5,
            "description": "Take a nap",
            "completed": false
        },
        {
            "todoid": 6,
            "description": "Rearrange my hutch",
            "completed": false
        },
        {
            "todoid": 7,
            "description": "Groom my fur",
            "completed": false
        }
    ]
}
```

</details>

<details>
<summary>POST http://localhost:2019/users/user</summary>

DATA

```JSON
  {
      "username": "lambdallama",
      "primaryemail": "llama@lambdaschool.local",
      "password": "ILuvM4th!",
      "todos": [
          {
              "description": "Take over the world"
          },
          {
              "description": "Make lasagna"
          }
      ]
  }
```

OUTPUT

```TEXT
Status OK
http://localhost:2019/users/user/12
```

</details>

<details>
<summary>http://localhost:2019/users/user/12</summary>

```JSON
{
    "userid": 12,
    "username": "lambdallama",
    "primaryemail": "llama@lambdaschool.local",
    "todos": [
        {
            "todoid": 13,
            "description": "Take over the world",
            "completed": false
        },
        {
            "todoid": 14,
            "description": "Make lasagna",
            "completed": false
        }
    ]
}
```

</details>

<details>
<summary>PATCH http://localhost:2019/todos/todo/6</summary>

OUTPUT

```TEXT
STATUS OK
```

</details>

<details>
<summary>localhost:2019/users/user/4</summary>

```JSON
{
    "userid": 4,
    "username": "cinnamon",
    "primaryemail": "cinnamon@lambdaschool.local",
    "todos": [
        {
            "todoid": 5,
            "description": "Take a nap",
            "completed": false
        },
        {
            "todoid": 6,
            "description": "Rearrange my hutch",
            "completed": true
        },
        {
            "todoid": 7,
            "description": "Groom my fur",
            "completed": false
        }
    ]
}
```

</details>

<details>
<summary>DELETE http://localhost:2019/users/user/10</summary>

OUTPUT

```TEXT
STATUS OK
```

</details>

<details>
<summary>http://localhost:2019/users/user/10</summary>

```JSON
{
    "timestamp": "2020-07-14 14:55:38",
    "status": 500,
    "error": "Internal Server Error",
    "message": "User id 10 not found!",
    "trace": "javax.persistence.EntityNotFoundException: User id 10 not found!\n\tat com.lambdaschool.todos.services.UserServiceImpl.lambda$findUserById$0(UserServiceImpl.java:37)\n\tat java.base/java.util.Optional.orElseThrow(Optional.java:401)\n\tat com.lambdaschool.todos.services.UserServiceImpl.findUserById(UserServiceImpl.java:37)\n\tat com.lambdaschool.todos.services.UserServiceImpl$$FastClassBySpringCGLIB$$3b13ff41.invoke(<generated>)\n\tat org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:769)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.transaction.interceptor.TransactionAspectSupport.invokeWithinTransaction(TransactionAspectSupport.java:366)\n\tat org.springframework.transaction.interceptor.TransactionInterceptor.invoke(TransactionInterceptor.java:99)\n\tat org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)\n\tat org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:747)\n\tat org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:689)\n\tat com.lambdaschool.todos.services.UserServiceImpl$$EnhancerBySpringCGLIB$$d1e3f76f.findUserById(<generated>)\n\tat com.lambdaschool.todos.controllers.UserController.getUserById(UserController.java:61)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\n\tat java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\n\tat java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\n\tat java.base/java.lang.reflect.Method.invoke(Method.java:564)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:190)\n\tat org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:138)\n\tat org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:879)\n\tat org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:793)\n\tat org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87)\n\tat org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1040)\n\tat org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:943)\n\tat org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006)\n\tat org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:898)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:634)\n\tat org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883)\n\tat javax.servlet.http.HttpServlet.service(HttpServlet.java:741)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:231)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201)\n\tat org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119)\n\tat org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:193)\n\tat org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:166)\n\tat org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202)\n\tat org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:96)\n\tat org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:541)\n\tat org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:139)\n\tat org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92)\n\tat org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74)\n\tat org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:343)\n\tat org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:367)\n\tat org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65)\n\tat org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:868)\n\tat org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1639)\n\tat org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1130)\n\tat java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:630)\n\tat org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61)\n\tat java.base/java.lang.Thread.run(Thread.java:832)\n",
    "path": "/users/user/10"
}
```

</details>

### Stretch Goals

<details>
<summary>http://localhost:2019/users/users/todos</summary>

```JSON
[
    {
        "usernamerpt": "admin",
        "counttodos": 2
    },
    {
        "usernamerpt": "barnbarn",
        "counttodos": 1
    },
    {
        "usernamerpt": "cinnamon",
        "counttodos": 3
    }
]
```

</details>

<details>
<summary>http://localhost:2019/users/users</summary>

```JSON
[
    {
        "userid": 1,
        "username": "admin",
        "primaryemail": "admin@lambdaschool.local",
        "todos": [
            {
                "todoid": 2,
                "description": "Give Joe access rights",
                "completed": false
            },
            {
                "todoid": 3,
                "description": "Change the color of the home page",
                "completed": false
            }
        ]
    },
    {
        "userid": 4,
        "username": "cinnamon",
        "primaryemail": "cinnamon@lambdaschool.local",
        "todos": [
            {
                "todoid": 5,
                "description": "Take a nap",
                "completed": false
            },
            {
                "todoid": 6,
                "description": "Rearrange my hutch",
                "completed": false
            },
            {
                "todoid": 7,
                "description": "Groom my fur",
                "completed": false
            }
        ]
    },
    {
        "userid": 8,
        "username": "barnbarn",
        "primaryemail": "barnbarn@lambdaschool.local",
        "todos": [
            {
                "todoid": 9,
                "description": "Rearrange my hutch",
                "completed": false
            }
        ]
    },
    {
        "userid": 10,
        "username": "puttat",
        "primaryemail": "puttat@school.lambda",
        "todos": []
    },
    {
        "userid": 11,
        "username": "misskitty",
        "primaryemail": "misskitty@school.lambda",
        "todos": []
    },
    {
        "userid": 12,
        "username": "kyle.wunsch",
        "primaryemail": "morton.predovic@gmail.com",
        "todos": [
            {
                "todoid": 13,
                "description": "Catch Onix",
                "completed": false
            },
            {
                "todoid": 14,
                "description": "Catch Seel",
                "completed": false
            },
            {
                "todoid": 15,
                "description": "Catch Seadra",
                "completed": false
            }
        ]
    },
    {
        "userid": 16,
        "username": "wilmer.bahringer",
        "primaryemail": "kyle.stoltenberg@yahoo.com",
        "todos": [
            {
                "todoid": 17,
                "description": "Catch Rapidash",
                "completed": false
            },
            {
                "todoid": 18,
                "description": "Catch Butterfree",
                "completed": false
            },
            {
                "todoid": 19,
                "description": "Catch Muk",
                "completed": false
            }
        ]
    },
    {
        "userid": 20,
        "username": "tamala.jacobs",
        "primaryemail": "darin.sipes@yahoo.com",
        "todos": [
            {
                "todoid": 21,
                "description": "Catch Oddish",
                "completed": false
            },
            {
                "todoid": 22,
                "description": "Catch Dragonair",
                "completed": false
            },
            {
                "todoid": 23,
                "description": "Catch Weedle",
                "completed": false
            }
        ]
    },
    {
        "userid": 24,
        "username": "aaron.braun",
        "primaryemail": "helen.homenick@gmail.com",
        "todos": [
            {
                "todoid": 25,
                "description": "Catch Fearow",
                "completed": false
            }
        ]
    },
    {
        "userid": 26,
        "username": "griselda.collins",
        "primaryemail": "ramiro.bayer@hotmail.com",
        "todos": [
            {
                "todoid": 27,
                "description": "Catch Arbok",
                "completed": false
            },
            {
                "todoid": 28,
                "description": "Catch Beedrill",
                "completed": false
            },
            {
                "todoid": 29,
                "description": "Catch Pikachu",
                "completed": false
            }
        ]
    },
    {
        "userid": 30,
        "username": "javier.schulist",
        "primaryemail": "edgar.mckenzie@yahoo.com",
        "todos": [
            {
                "todoid": 31,
                "description": "Catch Porygon",
                "completed": false
            },
            {
                "todoid": 32,
                "description": "Catch Beedrill",
                "completed": false
            }
        ]
    },
    {
        "userid": 33,
        "username": "barbera.raynor",
        "primaryemail": "douglass.bartoletti@yahoo.com",
        "todos": [
            {
                "todoid": 34,
                "description": "Catch Bellsprout",
                "completed": false
            },
            {
                "todoid": 35,
                "description": "Catch Meowth",
                "completed": false
            }
        ]
    },
    {
        "userid": 36,
        "username": "rosanne.steuber",
        "primaryemail": "delinda.bergstrom@hotmail.com",
        "todos": [
            {
                "todoid": 37,
                "description": "Catch Sandslash",
                "completed": false
            }
        ]
    },
    {
        "userid": 38,
        "username": "sam.mckenzie",
        "primaryemail": "dominique.ebert@hotmail.com",
        "todos": [
            {
                "todoid": 39,
                "description": "Catch Pidgeot",
                "completed": false
            },
            {
                "todoid": 40,
                "description": "Catch Aerodactyl",
                "completed": false
            },
            {
                "todoid": 41,
                "description": "Catch Wigglytuff",
                "completed": false
            }
        ]
    },
    {
        "userid": 42,
        "username": "branda.howe",
        "primaryemail": "carolynn.murray@hotmail.com",
        "todos": [
            {
                "todoid": 43,
                "description": "Catch Kakuna",
                "completed": false
            },
            {
                "todoid": 44,
                "description": "Catch Ekans",
                "completed": false
            }
        ]
    },
    {
        "userid": 45,
        "username": "gertrud.crona",
        "primaryemail": "linwood.marquardt@yahoo.com",
        "todos": [
            {
                "todoid": 46,
                "description": "Catch Gloom",
                "completed": false
            },
            {
                "todoid": 47,
                "description": "Catch Moltres",
                "completed": false
            },
            {
                "todoid": 48,
                "description": "Catch Spearow",
                "completed": false
            }
        ]
    },
    {
        "userid": 49,
        "username": "leo.osinski",
        "primaryemail": "neely.swift@yahoo.com",
        "todos": [
            {
                "todoid": 50,
                "description": "Catch Zapdos",
                "completed": false
            },
            {
                "todoid": 51,
                "description": "Catch Charmeleon",
                "completed": false
            }
        ]
    },
    {
        "userid": 52,
        "username": "shemika.brakus",
        "primaryemail": "doug.upton@hotmail.com",
        "todos": [
            {
                "todoid": 53,
                "description": "Catch Magneton",
                "completed": false
            },
            {
                "todoid": 54,
                "description": "Catch Slowpoke",
                "completed": false
            }
        ]
    },
    {
        "userid": 55,
        "username": "sam.bins",
        "primaryemail": "hang.mante@yahoo.com",
        "todos": [
            {
                "todoid": 56,
                "description": "Catch Nidoqueen",
                "completed": false
            },
            {
                "todoid": 57,
                "description": "Catch Sandshrew",
                "completed": false
            }
        ]
    },
    {
        "userid": 58,
        "username": "kathryn.mraz",
        "primaryemail": "larue.haley@hotmail.com",
        "todos": [
            {
                "todoid": 59,
                "description": "Catch Charmander",
                "completed": false
            },
            {
                "todoid": 60,
                "description": "Catch Dodrio",
                "completed": false
            }
        ]
    },
    {
        "userid": 61,
        "username": "elias.toy",
        "primaryemail": "earnestine.schiller@yahoo.com",
        "todos": [
            {
                "todoid": 62,
                "description": "Catch Krabby",
                "completed": false
            },
            {
                "todoid": 63,
                "description": "Catch Goldeen",
                "completed": false
            }
        ]
    },
    {
        "userid": 64,
        "username": "arlie.cassin",
        "primaryemail": "yun.aufderhar@hotmail.com",
        "todos": []
    },
    {
        "userid": 65,
        "username": "ashly.schimmel",
        "primaryemail": "asa.strosin@hotmail.com",
        "todos": [
            {
                "todoid": 66,
                "description": "Catch Rattata",
                "completed": false
            }
        ]
    },
    {
        "userid": 67,
        "username": "jeannette.lubowitz",
        "primaryemail": "jarrod.koepp@yahoo.com",
        "todos": [
            {
                "todoid": 68,
                "description": "Catch Arbok",
                "completed": false
            },
            {
                "todoid": 69,
                "description": "Catch Clefairy",
                "completed": false
            }
        ]
    },
    {
        "userid": 70,
        "username": "wan.haag",
        "primaryemail": "shalonda.graham@gmail.com",
        "todos": [
            {
                "todoid": 71,
                "description": "Catch Cloyster",
                "completed": false
            },
            {
                "todoid": 72,
                "description": "Catch Kakuna",
                "completed": false
            },
            {
                "todoid": 73,
                "description": "Catch Venusaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 74,
        "username": "bernardina.beahan",
        "primaryemail": "beula.hegmann@yahoo.com",
        "todos": [
            {
                "todoid": 75,
                "description": "Catch Diglett",
                "completed": false
            }
        ]
    },
    {
        "userid": 76,
        "username": "roman.maggio",
        "primaryemail": "isabelle.ryan@gmail.com",
        "todos": [
            {
                "todoid": 77,
                "description": "Catch Hypno",
                "completed": false
            }
        ]
    },
    {
        "userid": 78,
        "username": "don.parker",
        "primaryemail": "marlene.koepp@gmail.com",
        "todos": [
            {
                "todoid": 79,
                "description": "Catch Farfetch'd",
                "completed": false
            },
            {
                "todoid": 80,
                "description": "Catch Vaporeon",
                "completed": false
            },
            {
                "todoid": 81,
                "description": "Catch Lapras",
                "completed": false
            }
        ]
    },
    {
        "userid": 82,
        "username": "jesse.wunsch",
        "primaryemail": "wayne.murazik@gmail.com",
        "todos": [
            {
                "todoid": 83,
                "description": "Catch Dratini",
                "completed": false
            },
            {
                "todoid": 84,
                "description": "Catch Machop",
                "completed": false
            },
            {
                "todoid": 85,
                "description": "Catch Venonat",
                "completed": false
            }
        ]
    },
    {
        "userid": 86,
        "username": "dan.kunde",
        "primaryemail": "heike.bergnaum@hotmail.com",
        "todos": [
            {
                "todoid": 87,
                "description": "Catch Arbok",
                "completed": false
            }
        ]
    },
    {
        "userid": 88,
        "username": "casandra.legros",
        "primaryemail": "wilburn.sipes@gmail.com",
        "todos": []
    },
    {
        "userid": 89,
        "username": "yahaira.rice",
        "primaryemail": "hal.kertzmann@yahoo.com",
        "todos": []
    },
    {
        "userid": 90,
        "username": "gertrud.dickinson",
        "primaryemail": "katelin.reichel@gmail.com",
        "todos": [
            {
                "todoid": 91,
                "description": "Catch Doduo",
                "completed": false
            },
            {
                "todoid": 92,
                "description": "Catch Ninetales",
                "completed": false
            },
            {
                "todoid": 93,
                "description": "Catch Mew",
                "completed": false
            }
        ]
    },
    {
        "userid": 94,
        "username": "miles.graham",
        "primaryemail": "joesph.willms@gmail.com",
        "todos": [
            {
                "todoid": 95,
                "description": "Catch Snorlax",
                "completed": false
            }
        ]
    },
    {
        "userid": 96,
        "username": "rossana.powlowski",
        "primaryemail": "porsha.purdy@yahoo.com",
        "todos": [
            {
                "todoid": 97,
                "description": "Catch Gastly",
                "completed": false
            },
            {
                "todoid": 98,
                "description": "Catch Geodude",
                "completed": false
            }
        ]
    },
    {
        "userid": 99,
        "username": "demetrius.collins",
        "primaryemail": "kassie.waters@gmail.com",
        "todos": [
            {
                "todoid": 100,
                "description": "Catch Articuno",
                "completed": false
            }
        ]
    },
    {
        "userid": 101,
        "username": "royce.miller",
        "primaryemail": "steven.wisoky@gmail.com",
        "todos": [
            {
                "todoid": 102,
                "description": "Catch Tentacruel",
                "completed": false
            }
        ]
    },
    {
        "userid": 103,
        "username": "marlin.wisozk",
        "primaryemail": "roderick.hoppe@gmail.com",
        "todos": [
            {
                "todoid": 104,
                "description": "Catch Machoke",
                "completed": false
            }
        ]
    },
    {
        "userid": 105,
        "username": "chauncey.rolfson",
        "primaryemail": "anthony.swift@gmail.com",
        "todos": [
            {
                "todoid": 106,
                "description": "Catch Arbok",
                "completed": false
            }
        ]
    },
    {
        "userid": 107,
        "username": "kyle.steuber",
        "primaryemail": "estelle.hane@yahoo.com",
        "todos": [
            {
                "todoid": 108,
                "description": "Catch Clefairy",
                "completed": false
            }
        ]
    },
    {
        "userid": 109,
        "username": "cecile.metz",
        "primaryemail": "euna.cole@gmail.com",
        "todos": []
    },
    {
        "userid": 110,
        "username": "lonny.parker",
        "primaryemail": "madie.maggio@gmail.com",
        "todos": [
            {
                "todoid": 111,
                "description": "Catch Seaking",
                "completed": false
            },
            {
                "todoid": 112,
                "description": "Catch Flareon",
                "completed": false
            }
        ]
    },
    {
        "userid": 113,
        "username": "myles.cronin",
        "primaryemail": "annelle.treutel@gmail.com",
        "todos": [
            {
                "todoid": 114,
                "description": "Catch Kadabra",
                "completed": false
            }
        ]
    },
    {
        "userid": 115,
        "username": "guy.koepp",
        "primaryemail": "merle.kassulke@hotmail.com",
        "todos": []
    },
    {
        "userid": 116,
        "username": "malcolm.mueller",
        "primaryemail": "norbert.abernathy@hotmail.com",
        "todos": [
            {
                "todoid": 117,
                "description": "Catch Pinsir",
                "completed": false
            },
            {
                "todoid": 118,
                "description": "Catch Gyarados",
                "completed": false
            },
            {
                "todoid": 119,
                "description": "Catch Snorlax",
                "completed": false
            }
        ]
    },
    {
        "userid": 120,
        "username": "darrell.kirlin",
        "primaryemail": "dirk.trantow@yahoo.com",
        "todos": [
            {
                "todoid": 121,
                "description": "Catch Spearow",
                "completed": false
            }
        ]
    },
    {
        "userid": 122,
        "username": "carter.sawayn",
        "primaryemail": "loni.williamson@hotmail.com",
        "todos": [
            {
                "todoid": 123,
                "description": "Catch Machop",
                "completed": false
            },
            {
                "todoid": 124,
                "description": "Catch Raichu",
                "completed": false
            },
            {
                "todoid": 125,
                "description": "Catch Clefable",
                "completed": false
            }
        ]
    },
    {
        "userid": 126,
        "username": "tana.mueller",
        "primaryemail": "laurel.denesik@yahoo.com",
        "todos": [
            {
                "todoid": 127,
                "description": "Catch Cloyster",
                "completed": false
            },
            {
                "todoid": 128,
                "description": "Catch Grimer",
                "completed": false
            },
            {
                "todoid": 129,
                "description": "Catch Rhydon",
                "completed": false
            }
        ]
    },
    {
        "userid": 130,
        "username": "lula.zulauf",
        "primaryemail": "claris.schroeder@gmail.com",
        "todos": [
            {
                "todoid": 131,
                "description": "Catch Beedrill",
                "completed": false
            },
            {
                "todoid": 132,
                "description": "Catch Venusaur",
                "completed": false
            }
        ]
    },
    {
        "userid": 133,
        "username": "jordan.champlin",
        "primaryemail": "phoebe.hahn@gmail.com",
        "todos": [
            {
                "todoid": 134,
                "description": "Catch Goldeen",
                "completed": false
            },
            {
                "todoid": 135,
                "description": "Catch Sandshrew",
                "completed": false
            },
            {
                "todoid": 136,
                "description": "Catch Articuno",
                "completed": false
            }
        ]
    },
    {
        "userid": 137,
        "username": "man.bernier",
        "primaryemail": "brant.howell@hotmail.com",
        "todos": []
    },
    {
        "userid": 138,
        "username": "phillip.spinka",
        "primaryemail": "caren.heaney@gmail.com",
        "todos": [
            {
                "todoid": 139,
                "description": "Catch Weezing",
                "completed": false
            }
        ]
    },
    {
        "userid": 140,
        "username": "trinidad.pollich",
        "primaryemail": "osvaldo.kuhlman@gmail.com",
        "todos": []
    },
    {
        "userid": 141,
        "username": "jessi.schimmel",
        "primaryemail": "sandra.watsica@yahoo.com",
        "todos": [
            {
                "todoid": 142,
                "description": "Catch Arbok",
                "completed": false
            },
            {
                "todoid": 143,
                "description": "Catch Abra",
                "completed": false
            }
        ]
    },
    {
        "userid": 144,
        "username": "cary.rodriguez",
        "primaryemail": "carolyne.crona@hotmail.com",
        "todos": [
            {
                "todoid": 145,
                "description": "Catch Charmander",
                "completed": false
            },
            {
                "todoid": 146,
                "description": "Catch Tauros",
                "completed": false
            }
        ]
    },
    {
        "userid": 147,
        "username": "daren.cassin",
        "primaryemail": "tamica.pfeffer@hotmail.com",
        "todos": [
            {
                "todoid": 148,
                "description": "Catch Exeggcute",
                "completed": false
            }
        ]
    },
    {
        "userid": 149,
        "username": "sparkle.fritsch",
        "primaryemail": "patricia.goldner@yahoo.com",
        "todos": []
    },
    {
        "userid": 150,
        "username": "marianela.borer",
        "primaryemail": "hilma.rogahn@gmail.com",
        "todos": [
            {
                "todoid": 151,
                "description": "Catch Slowbro",
                "completed": false
            },
            {
                "todoid": 152,
                "description": "Catch Alakazam",
                "completed": false
            },
            {
                "todoid": 153,
                "description": "Catch Mewtwo",
                "completed": false
            }
        ]
    },
    {
        "userid": 154,
        "username": "tod.murazik",
        "primaryemail": "benita.pouros@yahoo.com",
        "todos": []
    },
    {
        "userid": 155,
        "username": "laci.price",
        "primaryemail": "rowena.ohara@gmail.com",
        "todos": [
            {
                "todoid": 156,
                "description": "Catch Meowth",
                "completed": false
            }
        ]
    },
    {
        "userid": 157,
        "username": "zenia.wehner",
        "primaryemail": "guy.aufderhar@hotmail.com",
        "todos": [
            {
                "todoid": 158,
                "description": "Catch Onix",
                "completed": false
            },
            {
                "todoid": 159,
                "description": "Catch Lapras",
                "completed": false
            },
            {
                "todoid": 160,
                "description": "Catch Slowpoke",
                "completed": false
            }
        ]
    },
    {
        "userid": 161,
        "username": "jacques.wolff",
        "primaryemail": "carlena.stracke@hotmail.com",
        "todos": []
    },
    {
        "userid": 162,
        "username": "jerry.rau",
        "primaryemail": "yael.aufderhar@yahoo.com",
        "todos": [
            {
                "todoid": 163,
                "description": "Catch Metapod",
                "completed": false
            },
            {
                "todoid": 164,
                "description": "Catch Gloom",
                "completed": false
            },
            {
                "todoid": 165,
                "description": "Catch Nidorino",
                "completed": false
            }
        ]
    },
    {
        "userid": 166,
        "username": "thaddeus.wolf",
        "primaryemail": "ashlie.boyle@yahoo.com",
        "todos": [
            {
                "todoid": 167,
                "description": "Catch Gastly",
                "completed": false
            },
            {
                "todoid": 168,
                "description": "Catch Wigglytuff",
                "completed": false
            }
        ]
    },
    {
        "userid": 169,
        "username": "reyes.rogahn",
        "primaryemail": "elliott.gutmann@gmail.com",
        "todos": [
            {
                "todoid": 170,
                "description": "Catch Ditto",
                "completed": false
            },
            {
                "todoid": 171,
                "description": "Catch Paras",
                "completed": false
            },
            {
                "todoid": 172,
                "description": "Catch Butterfree",
                "completed": false
            }
        ]
    },
    {
        "userid": 173,
        "username": "sandi.dooley",
        "primaryemail": "maire.hagenes@gmail.com",
        "todos": [
            {
                "todoid": 174,
                "description": "Catch Scyther",
                "completed": false
            }
        ]
    },
    {
        "userid": 175,
        "username": "dillon.langworth",
        "primaryemail": "genny.quitzon@gmail.com",
        "todos": []
    },
    {
        "userid": 176,
        "username": "melonie.crooks",
        "primaryemail": "eileen.blanda@yahoo.com",
        "todos": [
            {
                "todoid": 177,
                "description": "Catch Kadabra",
                "completed": false
            },
            {
                "todoid": 178,
                "description": "Catch Poliwrath",
                "completed": false
            }
        ]
    },
    {
        "userid": 179,
        "username": "hiroko.west",
        "primaryemail": "jimmie.runolfsdottir@gmail.com",
        "todos": [
            {
                "todoid": 180,
                "description": "Catch Paras",
                "completed": false
            }
        ]
    },
    {
        "userid": 181,
        "username": "juana.dickinson",
        "primaryemail": "tequila.rau@yahoo.com",
        "todos": []
    },
    {
        "userid": 182,
        "username": "winston.bergstrom",
        "primaryemail": "winfred.dubuque@hotmail.com",
        "todos": [
            {
                "todoid": 183,
                "description": "Catch Rattata",
                "completed": false
            },
            {
                "todoid": 184,
                "description": "Catch Primeape",
                "completed": false
            }
        ]
    },
    {
        "userid": 185,
        "username": "frankie.heaney",
        "primaryemail": "ollie.stiedemann@hotmail.com",
        "todos": [
            {
                "todoid": 186,
                "description": "Catch Snorlax",
                "completed": false
            }
        ]
    },
    {
        "userid": 187,
        "username": "scott.pagac",
        "primaryemail": "kimberley.runolfsdottir@hotmail.com",
        "todos": [
            {
                "todoid": 188,
                "description": "Catch Dugtrio",
                "completed": false
            },
            {
                "todoid": 189,
                "description": "Catch Zubat",
                "completed": false
            }
        ]
    },
    {
        "userid": 190,
        "username": "angelo.hayes",
        "primaryemail": "venetta.thompson@hotmail.com",
        "todos": []
    },
    {
        "userid": 191,
        "username": "andrew.green",
        "primaryemail": "chong.macgyver@hotmail.com",
        "todos": [
            {
                "todoid": 192,
                "description": "Catch Clefable",
                "completed": false
            }
        ]
    },
    {
        "userid": 193,
        "username": "tamekia.cummerata",
        "primaryemail": "madelyn.lemke@yahoo.com",
        "todos": []
    },
    {
        "userid": 194,
        "username": "benny.strosin",
        "primaryemail": "kandace.thompson@yahoo.com",
        "todos": []
    },
    {
        "userid": 195,
        "username": "nu.kohler",
        "primaryemail": "bettye.rath@hotmail.com",
        "todos": []
    },
    {
        "userid": 196,
        "username": "shirley.gislason",
        "primaryemail": "herschel.purdy@gmail.com",
        "todos": [
            {
                "todoid": 197,
                "description": "Catch Pidgeot",
                "completed": false
            },
            {
                "todoid": 198,
                "description": "Catch Growlithe",
                "completed": false
            }
        ]
    },
    {
        "userid": 199,
        "username": "ashanti.okon",
        "primaryemail": "burton.runolfsson@hotmail.com",
        "todos": []
    },
    {
        "userid": 200,
        "username": "janie.lang",
        "primaryemail": "jaime.koelpin@yahoo.com",
        "todos": [
            {
                "todoid": 201,
                "description": "Catch Seel",
                "completed": false
            },
            {
                "todoid": 202,
                "description": "Catch Gyarados",
                "completed": false
            }
        ]
    },
    {
        "userid": 203,
        "username": "audie.larkin",
        "primaryemail": "toshiko.upton@hotmail.com",
        "todos": [
            {
                "todoid": 204,
                "description": "Catch Exeggutor",
                "completed": false
            }
        ]
    },
    {
        "userid": 205,
        "username": "james.graham",
        "primaryemail": "lovie.rosenbaum@gmail.com",
        "todos": [
            {
                "todoid": 206,
                "description": "Catch Pidgey",
                "completed": false
            },
            {
                "todoid": 207,
                "description": "Catch Seaking",
                "completed": false
            }
        ]
    },
    {
        "userid": 208,
        "username": "virgil.cassin",
        "primaryemail": "jeramy.bogan@hotmail.com",
        "todos": []
    },
    {
        "userid": 209,
        "username": "lilliana.hauck",
        "primaryemail": "windy.purdy@gmail.com",
        "todos": [
            {
                "todoid": 210,
                "description": "Catch Kingler",
                "completed": false
            },
            {
                "todoid": 211,
                "description": "Catch Golbat",
                "completed": false
            }
        ]
    },
    {
        "userid": 212,
        "username": "dori.lockman",
        "primaryemail": "roland.franecki@yahoo.com",
        "todos": [
            {
                "todoid": 213,
                "description": "Catch Clefable",
                "completed": false
            },
            {
                "todoid": 214,
                "description": "Catch Vileplume",
                "completed": false
            },
            {
                "todoid": 215,
                "description": "Catch Paras",
                "completed": false
            }
        ]
    },
    {
        "userid": 216,
        "username": "elmer.hermann",
        "primaryemail": "sybil.klein@yahoo.com",
        "todos": []
    },
    {
        "userid": 217,
        "username": "ana.ondricka",
        "primaryemail": "liliana.gutkowski@gmail.com",
        "todos": [
            {
                "todoid": 218,
                "description": "Catch Vaporeon",
                "completed": false
            }
        ]
    },
    {
        "userid": 219,
        "username": "adrianna.rice",
        "primaryemail": "charla.wintheiser@hotmail.com",
        "todos": []
    },
    {
        "userid": 220,
        "username": "lyndsey.kirlin",
        "primaryemail": "jama.cassin@gmail.com",
        "todos": [
            {
                "todoid": 221,
                "description": "Catch Scyther",
                "completed": false
            }
        ]
    },
    {
        "userid": 222,
        "username": "norbert.gerhold",
        "primaryemail": "krystyna.fahey@yahoo.com",
        "todos": [
            {
                "todoid": 223,
                "description": "Catch Golem",
                "completed": false
            }
        ]
    },
    {
        "userid": 224,
        "username": "tanja.leffler",
        "primaryemail": "garry.ebert@yahoo.com",
        "todos": []
    },
    {
        "userid": 225,
        "username": "chae.franecki",
        "primaryemail": "marge.russel@gmail.com",
        "todos": [
            {
                "todoid": 226,
                "description": "Catch Pidgeot",
                "completed": false
            },
            {
                "todoid": 227,
                "description": "Catch Koffing",
                "completed": false
            }
        ]
    },
    {
        "userid": 228,
        "username": "oliva.block",
        "primaryemail": "lou.hammes@gmail.com",
        "todos": [
            {
                "todoid": 229,
                "description": "Catch Venusaur",
                "completed": false
            },
            {
                "todoid": 230,
                "description": "Catch Wartortle",
                "completed": false
            }
        ]
    },
    {
        "userid": 231,
        "username": "malik.okeefe",
        "primaryemail": "emerson.walter@hotmail.com",
        "todos": [
            {
                "todoid": 232,
                "description": "Catch Venomoth",
                "completed": false
            },
            {
                "todoid": 233,
                "description": "Catch Eevee",
                "completed": false
            }
        ]
    },
    {
        "userid": 234,
        "username": "warner.kautzer",
        "primaryemail": "freeman.moore@gmail.com",
        "todos": [
            {
                "todoid": 235,
                "description": "Catch Primeape",
                "completed": false
            },
            {
                "todoid": 236,
                "description": "Catch Poliwag",
                "completed": false
            },
            {
                "todoid": 237,
                "description": "Catch Zubat",
                "completed": false
            }
        ]
    },
    {
        "userid": 238,
        "username": "jarod.wunsch",
        "primaryemail": "ettie.dubuque@yahoo.com",
        "todos": []
    },
    {
        "userid": 239,
        "username": "darron.schimmel",
        "primaryemail": "rasheeda.schoen@gmail.com",
        "todos": [
            {
                "todoid": 240,
                "description": "Catch Aerodactyl",
                "completed": false
            },
            {
                "todoid": 241,
                "description": "Catch Articuno",
                "completed": false
            },
            {
                "todoid": 242,
                "description": "Catch Dugtrio",
                "completed": false
            }
        ]
    },
    {
        "userid": 243,
        "username": "debbra.rowe",
        "primaryemail": "gayla.howe@hotmail.com",
        "todos": [
            {
                "todoid": 244,
                "description": "Catch Charmeleon",
                "completed": false
            },
            {
                "todoid": 245,
                "description": "Catch Tangela",
                "completed": false
            }
        ]
    },
    {
        "userid": 246,
        "username": "phil.fadel",
        "primaryemail": "michal.jaskolski@yahoo.com",
        "todos": [
            {
                "todoid": 247,
                "description": "Catch Arbok",
                "completed": false
            },
            {
                "todoid": 248,
                "description": "Catch Dragonite",
                "completed": false
            },
            {
                "todoid": 249,
                "description": "Catch Vileplume",
                "completed": false
            }
        ]
    },
    {
        "userid": 250,
        "username": "joline.dibbert",
        "primaryemail": "wilbur.gottlieb@gmail.com",
        "todos": []
    },
    {
        "userid": 251,
        "username": "reanna.schmitt",
        "primaryemail": "alex.hodkiewicz@gmail.com",
        "todos": [
            {
                "todoid": 252,
                "description": "Catch Venomoth",
                "completed": false
            }
        ]
    },
    {
        "userid": 253,
        "username": "candis.skiles",
        "primaryemail": "santiago.wolff@hotmail.com",
        "todos": []
    },
    {
        "userid": 254,
        "username": "russell.harris",
        "primaryemail": "kiersten.dickinson@gmail.com",
        "todos": []
    },
    {
        "userid": 255,
        "username": "sammy.kozey",
        "primaryemail": "nicholas.quigley@hotmail.com",
        "todos": [
            {
                "todoid": 256,
                "description": "Catch Paras",
                "completed": false
            }
        ]
    }
]
```

</details>

### Commits

Commit your code regularly and meaningfully. This helps both you (in case you ever need to return to old code for any number of reasons) and your team lead as the evaluate your solution.

Be prepared to demonstrate your understanding of this week's concepts by answering questions on the following topics. You might prepare by writing down your own answers before hand.

1. Can you explain your data model, data schema to me?
2. Can you explain how you connected your API to a database?
3. Can you explain the flow of data from client through the backend system and back to the client?
4. How did you handle querying in your application: custom querying vs JPA Querying?

## Instructions

### Task 1: Project Set Up

- [x] Create a forked copy of this project
- [x] Add your team lead as collaborator on Github
- [x] Clone your OWN version of the repository (Not Lambda's by mistake!)
- [x] Create a new branch: git checkout -b `<firstName-lastName>`.
- [x] Start with the provided todo application
- [x] Push commits: `git push origin <firstName-lastName>`
- [x] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly
- [x] Push commits: git push origin `<firstName-lastName>`

### Task 2: Project Requirements

You will be creating a REST api service to store and read data from an H2 database.

- [x] Please fork and clone this repository. This repository has a starting application called todos. You must start working from there. Regularly commit and push your code as appropriate.

- [ ] The initial application contains the model for the users table. Endpoints are already created and the structure for auditing fields is in place. You are adding the model for the todos table and updating the services to work with the new table.

- [ ] TODOS
  - `todoid` primary key, not null long
  - `description` string, not null
  - `completed` boolean. Note that for all new todos, default completed to false
  - `userid` foreign key (one user to many todos) not null
  - All tables must have the standard 4 auditing fields in place and working, being populated: created on, created by, last modified on, last modified by. The auditing usernames will all default to `llama`.
  - USERS have a one to many relationship with TODOS.

- [ ] SeedData.java is a sample class that can be modified to populate the database. However, this is the seed data to use for this application. The structure can change, the data should not change. Do populate the database with this data.

The following end points are already available in the initial application. You are to make sure the end points work with the newly added todos table

- [ ] GET /users/users - return all of the users and their todos.

- [ ] GET /users/user/{userid} - return the user and their todos based off of user id.

- [ ] POST /users/user - adds a user with their todos

  You can use the following to test this!

  ```JSON
  {
      "username": "lambdallama",
      "primaryemail": "llama@lambdaschool.local",
      "password": "ILuvM4th!",
      "todos": [
          {
              "description": "Take over the world"
          },
          {
              "description": "Make lasagna"
          }
      ]
  }
  ```

- [ ] PATCH /todos/todo/{todoid} - mark a todo as completed.

- [ ] DELETE /users/user/{userid} - Deletes a user based off of their userid and deletes all their associated todos.

### Required best practices

- [x] Consistent naming. Examples: variables, functions, Components, and file/folder organization.
- [x] Consistent spacing. Examples: line breaks, around arguments and before/after functions.
- [x] Consistent quotation usage.
- [x] Spell-check.
- [ \x] Schedule time to review, refine and reassess your work.

It is better to submit a challenge that meets [MVP](https://en.wikipedia.org/wiki/Minimum_viable_product) than one that attempts too much and fails.

### Tips and Gotchas

In your solution, it is essential that you follow best practices and produce clean and professional results. You will be scored on your adherence to proper code style and good organization. Schedule time to review, refine, and assess your work and perform basic professional polishing including spell-checking and grammar-checking on your work. It is better to submit a challenge that meets MVP than one that attempts too much and does not.

### Task 3: Stretch Goals

- [ ] GET /users/users/todos - lists the number of todos each user has that are NOT completed. Use a custom query to accomplish this!
  - Users with 0 todos do NOT have to be included in the list
  - Order the list by username!
  
- [ ] Add in 100 more random users each with a random number (0 - 3) of random todos. The todos descriptions should be something random as well. For my example, I picked Pokemon names!
