package com.example.bemediasearch.controller;




import com.example.bemediasearch.payload.response.ImageSearchResponse;
import com.example.bemediasearch.payload.resquest.ImageSearchRequest;
import com.example.bemediasearch.payload.resquest.OpenverseSearchRequest;
import com.example.bemediasearch.service.OpenverseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("api/openverse")
@Tag(name = "OpenverseController", description = "Openverse Controller")
public class OpenverseController {

    @Autowired
    private OpenverseService openverseService;

    @PostMapping("/search")
    public ResponseEntity<ImageSearchResponse> search(@ParameterObject ImageSearchRequest request) {
        ImageSearchResponse response = openverseService.searchImages(request);
        return ResponseEntity.ok(response);
    }

//    @PostMapping("/signin")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//
//        return ResponseEntity.ok(new JwtAuthenticationResponse(authService.authenticateUser(loginRequest)));
//    }
//
//    @PostMapping("/signup")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if (userService.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
//                HttpStatus.BAD_REQUEST);
//        }
//        if (userService.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
//                HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.created(authService.registerUser(signUpRequest, RoleName.ROLE_USER)).body(new ApiResponse(true, "User registered successfully"));
//    }
//    @PreAuthorize("hasRole('ADMIN')")
//    @PostMapping("/registerStaff")
//    public ResponseEntity<?> registerStaff(@Valid @RequestBody SignUpRequest signUpRequest) {
//        if (userService.existsByUsername(signUpRequest.getUsername())) {
//            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
//                HttpStatus.BAD_REQUEST);
//        }
//        if (userService.existsByEmail(signUpRequest.getEmail())) {
//            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
//                HttpStatus.BAD_REQUEST);
//        }
//        return ResponseEntity.created(authService.registerUser(signUpRequest, RoleName.ROLE_STAFF)).body(new ApiResponse(true, "User registered successfully"));
//    }
//    @PutMapping("/changePassword")
//    public ResponseEntity<?> changePassword(@CurrentUser UserPrincipal currentUser , @Valid @RequestParam String newPassword, @Valid @RequestParam String oldPassword) {
//        if(authService.changePassword(currentUser,newPassword,oldPassword))
//            return new ResponseEntity(new ApiResponse(true, "Success! New password can be use right now!") , HttpStatus.OK);
//        return new ResponseEntity(new ApiResponse(false, "Fail to change password!"),  HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
