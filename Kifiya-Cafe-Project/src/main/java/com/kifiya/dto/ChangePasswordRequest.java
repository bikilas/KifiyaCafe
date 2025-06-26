
package com.kifiya.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChangePasswordRequest {
   private @NotBlank(
   message = "Current password is required"
) String currentPassword;
   private @NotBlank(
   message = "New password is required"
) @Size(
   min = 6,
   message = "Password must be at least 6 characters"
) String newPassword;
   private @NotBlank(
   message = "Confirm password is required"
) String confirmNewPassword;

   public ChangePasswordRequest() {
   }

   public String getCurrentPassword() {
      return this.currentPassword;
   }

   public String getNewPassword() {
      return this.newPassword;
   }

   public String getConfirmNewPassword() {
      return this.confirmNewPassword;
   }

   public void setCurrentPassword(final String currentPassword) {
      this.currentPassword = currentPassword;
   }

   public void setNewPassword(final String newPassword) {
      this.newPassword = newPassword;
   }

   public void setConfirmNewPassword(final String confirmNewPassword) {
      this.confirmNewPassword = confirmNewPassword;
   }

   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ChangePasswordRequest)) {
         return false;
      } else {
         ChangePasswordRequest other = (ChangePasswordRequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            label47: {
               Object this$currentPassword = this.getCurrentPassword();
               Object other$currentPassword = other.getCurrentPassword();
               if (this$currentPassword == null) {
                  if (other$currentPassword == null) {
                     break label47;
                  }
               } else if (this$currentPassword.equals(other$currentPassword)) {
                  break label47;
               }

               return false;
            }

            Object this$newPassword = this.getNewPassword();
            Object other$newPassword = other.getNewPassword();
            if (this$newPassword == null) {
               if (other$newPassword != null) {
                  return false;
               }
            } else if (!this$newPassword.equals(other$newPassword)) {
               return false;
            }

            Object this$confirmNewPassword = this.getConfirmNewPassword();
            Object other$confirmNewPassword = other.getConfirmNewPassword();
            if (this$confirmNewPassword == null) {
               if (other$confirmNewPassword != null) {
                  return false;
               }
            } else if (!this$confirmNewPassword.equals(other$confirmNewPassword)) {
               return false;
            }

            return true;
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ChangePasswordRequest;
   }

   public int hashCode() {
      boolean PRIME = true;
      int result = 1;
      Object $currentPassword = this.getCurrentPassword();
      result = result * 59 + ($currentPassword == null ? 43 : $currentPassword.hashCode());
      Object $newPassword = this.getNewPassword();
      result = result * 59 + ($newPassword == null ? 43 : $newPassword.hashCode());
      Object $confirmNewPassword = this.getConfirmNewPassword();
      result = result * 59 + ($confirmNewPassword == null ? 43 : $confirmNewPassword.hashCode());
      return result;
   }

   public String toString() {
      String var10000 = this.getCurrentPassword();
      return "ChangePasswordRequest(currentPassword=" + var10000 + ", newPassword=" + this.getNewPassword() + ", confirmNewPassword=" + this.getConfirmNewPassword() + ")";
   }
}





















// package com.kifiya.dto;

// // import lombok.Data;
// // import javax.validation.constraints.NotBlank;
// // import javax.validation.constraints.Size;

// // @Data
// // public class ChangePasswordRequest {
// //     @NotBlank(message = "Current password is required")
// //     private String currentPassword;
    
// //     @NotBlank(message = "New password is required")
// //     @Size(min = 6, message = "Password must be at least 6 characters")
// //     private String newPassword;
    
// //     @NotBlank(message = "Confirm password is required")
// //     private String confirmNewPassword;
// // }package com.kifiya.dto;

// import lombok.Data;
// import jakarta.validation.constraints.NotBlank;
// import jakarta.validation.constraints.Size;

// @Data
// public class ChangePasswordRequest {
//     @NotBlank(message = "Current password is required")
//     private String currentPassword;
    
//     @NotBlank(message = "New password is required")
//     @Size(min = 6, message = "Password must be at least 6 characters")
//     private String newPassword;
    
//     @NotBlank(message = "Confirm password is required")
//     private String confirmNewPassword;
// }