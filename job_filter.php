<?php
require "connect.php";
if(isset($_POST["KEY"]) ){
$key=$_POST["KEY"];}
$q="select * from medical_job where job_place like '$key';";

$res=mysqli_query($con ,$q);

$result = array();
while($row=mysqli_fetch_assoc($res) )
{

mysqli_set_charset($con,"utf8");
    array_push($result,array(
        'job_name'=>$row["job_name"],
        'job_place'=>$row["job_place"],
        'sek_type'=>$row["sek_type"],
        'years_experience'=>$row["years_experience"],
        'age'=>$row['Age'],
	'spicialization'=>$row["spicialization"],
	'gualification'=>$row["gualification"],
	'adve_data'=>$row["adve_data"],
	'end_data'=>$row["end_data"],
	'salary'=>$row["salary"]
    ));
    
}//while

echo json_encode(array('result'=>$result));

?>
