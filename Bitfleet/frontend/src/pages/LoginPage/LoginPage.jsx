import "./LoginPage.css";
import { useState } from "react";
import { useNavigate } from "react-router-dom";


export default function LoginPage() {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    async function handleSubmit(e) {
        e.preventDefault();
        
        const response = await fetch("/api/admirals/login", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({username: username, password: password}),
        })

        if (response.status === 200) {
            const data = await response.json();
            navigate(`/admiral/${data.id}`);
        }
    }

    return (
        <div>
            <p>Login</p>
            <form onSubmit={handleSubmit}>
                <input placeholder="Username" type="text" value={username} onChange={(e) => setUsername(e.target.value)}/>
                <input placeholder="Password" type="password" value={password} onChange={(e) => setPassword(e.target.value)}/>
                <button>Login</button>
            </form>
        </div>
    )
}