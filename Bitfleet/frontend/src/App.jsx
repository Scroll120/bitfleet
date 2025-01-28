import { createBrowserRouter, Outlet, RouterProvider } from "react-router-dom";
import HomePage from './pages/homePage/HomePage.jsx';
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";

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
      ],
    },
  ]);

  return (
    <RouterProvider router={router}/>
  )
}

export default App
