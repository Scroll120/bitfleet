import "./HomePage.css";
import { useNavigate } from "react-router-dom";

export default function HomePage() {
    const navigate = useNavigate();

    return (
        <div>
            <p>Bitfleet</p>
            <button onClick={() => {navigate("/login")}}>Login</button>
        </div>
    )
}