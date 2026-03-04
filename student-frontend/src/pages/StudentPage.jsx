import { useEffect, useState } from "react";
import { getAllStudents } from "../api/studentApi";
import StudentForm from "../components/StudentForm";
import StudentList from "../components/StudentList";
import StudentSearch from "../components/StudentSearch";

const StudentPage = () => {
  const [students, setStudents] = useState([]);

  const loadStudents = async () => {
    const response = await getAllStudents();
    setStudents(response.data);
  };

  useEffect(() => {
    loadStudents();
  }, []);

  return (
    <div>
      <StudentForm onStudentAdded={loadStudents} />
      <StudentSearch onSearch={setStudents} />
      <StudentList students={students} refresh={loadStudents} />
    </div>
  );
};

export default StudentPage;
