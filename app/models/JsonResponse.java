package models;

public class JsonResponse
{
   private String status;
   public String msg;

   private JsonResponse(String status, String msg)
   {
      this.status = status;
      this.msg = msg;
   }
   public static JsonResponse createOk(String msg)
   {
      return new JsonResponse("OK", msg);
   }
   public static JsonResponse createError(String msg)
   {
      return new JsonResponse("ERROR", msg);
   }
}