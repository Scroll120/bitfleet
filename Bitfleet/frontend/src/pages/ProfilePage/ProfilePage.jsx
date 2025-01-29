import "./ProfilePage.css";
import { useState, useEffect } from "react";
import { useParams, useNavigate } from "react-router-dom";



export default function ProfilePage() {
    const [userData, setUserData] = useState(null);
    const {id} = useParams();
    const navigate = useNavigate();

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

    const startBattle = (fleetId) => {
        navigate("/battle", {state: { fleetId }});
    };

    return (
        <section className="userPage">
            {userData && (
                <div>
                    <p>{userData.username}</p>
                    {userData.fleets.map((fleet) => (
                        <div key={fleet.id}>
                            <p>{fleet.name}</p>
                            <button onClick={() => startBattle(fleet.id)}>Battle</button>
                        </div>
                    ))}
                </div>
            )}
        </section>
    )
}