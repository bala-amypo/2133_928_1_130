[INFO] 18 errors 
[INFO] -------------------------------------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  25.180 s
[INFO] Finished at: 2025-12-26T03:26:28Z
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.11.0:testCompile (default-testCompile) on project demo: Compilation failure: Compilation failure: 
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[164,29] constructor AuthController in class com.example.demo.controller.AuthController cannot be applied to given types;
[ERROR]   required: com.example.demo.service.UserService
[ERROR]   found:    com.example.demo.repository.UserRepository,com.example.demo.DemoBigTestNGSuiteTest.PasswordEncoderStub,com.example.demo.security.JwtTokenProvider
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[187,29] constructor AuthController in class com.example.demo.controller.AuthController cannot be applied to given types;
[ERROR]   required: com.example.demo.service.UserService
[ERROR]   found:    com.example.demo.repository.UserRepository,com.example.demo.DemoBigTestNGSuiteTest.PasswordEncoderStub,com.example.demo.security.JwtTokenProvider
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[188,46] incompatible types: com.example.demo.dto.RegisterRequest cannot be converted to com.example.demo.dto.AuthRequest
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[202,29] constructor AuthController in class com.example.demo.controller.AuthController cannot be applied to given types;
[ERROR]   required: com.example.demo.service.UserService
[ERROR]   found:    com.example.demo.repository.UserRepository,com.example.demo.DemoBigTestNGSuiteTest.PasswordEncoderStub,com.example.demo.security.JwtTokenProvider
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[207,41] incompatible types: com.example.demo.dto.AuthResponse cannot be converted to org.springframework.http.ResponseEntity<?>
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[282,57] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[302,81] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[319,81] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[339,36] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[347,52] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[362,73] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[473,52] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[566,29] constructor AuthController in class com.example.demo.controller.AuthController cannot be applied to given types;
[ERROR]   required: com.example.demo.service.UserService
[ERROR]   found:    com.example.demo.repository.UserRepository,com.example.demo.DemoBigTestNGSuiteTest.PasswordEncoderStub,com.example.demo.security.JwtTokenProvider
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[569,42] incompatible types: com.example.demo.dto.AuthResponse cannot be converted to org.springframework.http.ResponseEntity<?>
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[576,29] constructor AuthController in class com.example.demo.controller.AuthController cannot be applied to given types;
[ERROR]   required: com.example.demo.service.UserService
[ERROR]   found:    com.example.demo.repository.UserRepository,com.example.demo.DemoBigTestNGSuiteTest.PasswordEncoderStub,com.example.demo.security.JwtTokenProvider
[ERROR]   reason: actual and formal argument lists differ in length
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[582,43] incompatible types: com.example.demo.dto.RegisterRequest cannot be converted to com.example.demo.dto.AuthRequest
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[611,87] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] /home/coder/Workspace/demo/src/test/java/com/example/demo/DemoBigTestNGSuiteTest.java:[645,73] cannot find symbol
[ERROR]   symbol:   method builder()
[ERROR]   location: class com.example.demo.model.WarrantyClaimRecord
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException