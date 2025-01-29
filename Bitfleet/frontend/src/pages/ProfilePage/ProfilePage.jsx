import "./ProfilePage.css";
import { useState, useEffect } from "react";
import { useParams } from "react-router-dom";



export default function ProfilePage() {
    const [userData, setUserData] = useState(null);
    const {id} = useParams();

    useEffect(() => {
        fetchUserData();
    },[])

    const fetchUserData = async () => {
        const response = await fetch(`/api/admirals/${id}`, {
            method: 'GET',
            headers: {
                "Content-Type": "application/json",
            },
        });
        const data = await response.json();
        setUserData(data);
    }

    return (
        <section className="userPage">
            {userData && (
                <div>
                    <p>{userData.username}</p>
                </div>
            )}
        </section>
    )
}