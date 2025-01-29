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

        <section>
            {battleData && (
                <div>
                    <div>
                        <p>Fleet Name: {battleData.playerFleet.name}</p>
                        <p>Fleet Size: {battleData.playerFleet.ships.length}</p>
                        <p>Organisation: {battleData.playerFleet.org}</p>
                        <p>Screening Efficiency: {battleData.playerFleet.screening}</p>
                        <p>Fleet Value: {battleData.playerFleet.value}</p>
                    </div>
                    <div>
                        <p>Fleet Name: {battleData.enemyFleet.name}</p>
                        <p>Fleet Size: {battleData.enemyFleet.ships.length}</p>
                        <p>Organisation: {battleData.enemyFleet.org}</p>
                        <p>Screening Efficiency: {battleData.enemyFleet.screening}</p>
                        <p>Fleet Value: {battleData.enemyFleet.value}</p>
                    </div>
                    <p>{battleData.battleReports}</p>
                </div>
            )}
        </section>
    )
}