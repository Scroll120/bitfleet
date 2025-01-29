import "./BattlePage.css";
import { useParams } from "react-router-dom";
import { useEffect, useState } from "react";



export default function BattlePage() {
    const {id} = useParams();
    const [battleData, setBattleData] = useState(null);

    useEffect(() => {
        if (!id) return;

        fetchBattleData();
    }, [])

    const fetchBattleData = async () => {
        const response = await fetch(`/api/battle/start`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({id}),
        })
        const data = await response.json();
        setBattleData(data);
    }

    return (

        <div>
            <p>Battle</p>
            {battleData && (
                <p>{battleData.playerFleet.name}, {battleData.enemyFleet.name}</p>
            )}
        </div>
    )
}