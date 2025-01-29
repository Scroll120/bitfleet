import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import HomePage from './pages/homePage/HomePage.jsx';
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import LoginPage from "./pages/LoginPage/LoginPage.jsx";
import ProfilePage from "./pages/ProfilePage/ProfilePage.jsx";
import BattlePage from "./pages/battlePage/BattlePage.jsx";

function Layout() {
  return (
    <>
      <NavigationBar/>
      <Outlet/>
    </>
  )
}

function App() {


  const router = createBrowserRouter([
    
    {
      path: "/",
      element: <Layout
      />,
      children: [
        {
          path: "/",
          element: <HomePage/>
        },
        {
          path: "/login",
          element: <LoginPage/>
        },
        {
          path: "/admiral/:id",
          element: <ProfilePage/>
        },
        {
          path: "/battle",
          element: <BattlePage/>
        }
      ],
    },
  ]);

  return (
    <RouterProvider router={router}/>
  )
}

export default App
