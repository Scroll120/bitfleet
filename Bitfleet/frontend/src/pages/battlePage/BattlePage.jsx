import "./BattlePage.css";
import { useLocation } from "react-router-dom";
import { useEffect, useState } from "react";



export default function BattlePage() {
    const location = useLocation();
    const fleetId = location.state?.fleetId;
    const [battleData, setBattleData] = useState(null);

    useEffect(() => {
        console.log(fleetId);
    }, [])

    return (

        <div>
            <p>Battle</p>
        </div>
    )
}