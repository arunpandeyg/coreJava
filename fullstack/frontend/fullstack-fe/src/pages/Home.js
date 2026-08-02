import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';


export default function Home() {
  const [user, setUser] = useState([])
  
  const { id } = useParams();
    useEffect(() => {
        loadUser();
    },[]);
  const loadUser = async () => {
    const result = await axios.get("http://localhost:8080/user/");
    setUser(result.data);
  };
  
  const deleteUser = async (id) => {
    await axios.delete(`http://localhost:8080/user/${id}`);
    loadUser();
  };
 


  return (
    <div className="container">
      <div className="py-4">
        <table className="table border shadow">
          <thead>
            <tr>
              <th scope="col">S.N</th>
              <th scope="col">User Name</th>
              <th scope="col">Name</th>
              <th scope="col">Email</th>
              <th scope="col">Action</th>
            </tr>
          </thead>
          <tbody>
            {user.map((user, index) => (
              <tr>
                <th scope="row" key={index}>
                  {index + 1}
                </th>
                <td>{user.username}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>
                  <Link className="btn btn-primary mx-2" to={`/viewuser/${id}`} >View</Link>
                  <Link className="btn btn-outline-primary mx-2"
                  to={`/edituser/${user.id}`}>Edit</Link>
                  <Link className="btn btn-danger mx-2"
                  onClick={()=> deleteUser(user.id)} >Delete</Link>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
}
