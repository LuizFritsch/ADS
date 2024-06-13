document.addEventListener('DOMContentLoaded', () => {
    const loadingIndicator = document.getElementById('loadingIcon'); // Corrigido para loadingIndicator

    // Mocked Users
    const users = [
        { email: 'user1@example.com', password: '123' },
        { email: 'user2@example.com', password: 'password2' }
    ];

    // Mocked Professionals
    const professionals = [
        { id: 3, name: 'Dra. Maria Oliveira', specialty: 'Neurologista', rating: 5, location: 'Belo Horizonte', formattedAddress: 'Rua Das Oliveiras, 97', healthPlans: ['Plan A', 'Plan C'] },
        { id: 2, name: 'Dr. Carlos Souza', specialty: 'Dermatologista', rating: 4.2, location: 'Rio de Janeiro', formattedAddress: 'Rua das Jemeras, 456', healthPlans: ['Plan B', 'Plan C'] },
        { id: 1, name: 'Dr. João Silva', specialty: 'Cardiologista', rating: 4.5, location: 'São Paulo', formattedAddress: 'Rua das hortaliças, 123', healthPlans: ['Plan A', 'Plan D'] },
    ];

    // Collect all unique health plans
    const healthPlans = [...new Set(professionals.flatMap(pro => pro.healthPlans))];

    // Login Logic
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', function(event) {
            event.preventDefault();
            const email = document.getElementById('email').value;
            const password = document.getElementById('password').value;

            const user = users.find(u => u.email === email && u.password === password);
            if (user) {
                window.location.href = 'busca.html';
            } else {
                document.getElementById('loginError').textContent = 'Email ou senha inválidos';
            }
        });
    }

    // Search and Filter Logic
    let selectedPlans = [];

    function togglePlanFilter(plan) {
        const index = selectedPlans.indexOf(plan);
        if (index === -1) {
            selectedPlans.push(plan);
        } else {
            selectedPlans.splice(index, 1);
        }
        updateResults();
    }

    function normalizeString(str) {
        return str.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();
    }

    function updateResults() {
        const query = document.getElementById('searchBar').value.toLowerCase();
        let filteredProfessionals = professionals.filter(p =>
            (normalizeString(p.name).includes(query) ||
            normalizeString(p.specialty).includes(query) ||
            normalizeString(p.location).includes(query) ||
            p.healthPlans.some(plan => normalizeString(plan).includes(query))) &&
            (selectedPlans.length === 0 || selectedPlans.some(plan => p.healthPlans.includes(plan)))
        );

        const results = document.getElementById('results');
        results.innerHTML = '';
        filteredProfessionals.forEach(pro => {
            const card = document.createElement('div');
            card.className = 'professional-card';
            card.innerHTML = `
                <h2>${pro.name}</h2>
                <p>${pro.specialty}</p>
                <p>Local: ${pro.location}</p>
                <p>Endereço: ${pro.formattedAddress}</p>
                <p>Avaliação: ${pro.rating}</p>
                <p>Planos de Saúde: ${pro.healthPlans.map(plan => `<span class="pill">${plan}</span>`).join(' ')}</p>
                <button onclick="viewDetails(${pro.id})">Ver Detalhes</button>`;
            results.appendChild(card);
        });
    }

    window.viewDetails = function viewDetails(id) {
        const professional = professionals.find(p => p.id === id);
        if (professional) {
            localStorage.setItem('selectedProfessional', JSON.stringify(professional));
            window.location.href = 'detalhes.html';
        }
    };

    // Details Page Logic
    if (window.location.pathname.endsWith('detalhes.html')) { 
        const professional = JSON.parse(localStorage.getItem('selectedProfessional'));
        if (professional) {
            document.getElementById('details').innerHTML = `
                <h2>${professional.name}</h2>
                <p>Especialidade: ${professional.specialty}</p>
                <p>Local: ${professional.location}</p>
                <p>Endereço: ${professional.formattedAddress}</p>
                <p>Avaliação: ${professional.rating}</p>
                <p>Planos de Saúde: ${professional.healthPlans.map(plan => `<span class="pill">${plan}</span>`).join(' ')}</p>`;
        }
    }

    if (window.location.pathname.endsWith('busca.html')) {
        // Render health plan filter pills
        document.getElementById('searchBar').addEventListener('input', updateResults);
        const planFilters = document.getElementById('planFilters');
        document.getElementById('locationButton').addEventListener('click', () => {
            if (navigator.geolocation) {
                loadingIcon.classList.add('loading'); // Adiciona classe para ativar a animação de rotação
    
                navigator.geolocation.getCurrentPosition(position => {
                    const { latitude, longitude } = position.coords;
                    const request = `https://geocode.maps.co/reverse?lat=48.8584&lon=2.2945&api_key=664fd9b8bacd2716994447bqd10f5b5`;
                    fetch(request)
                        .then(response => response.json())
                        .then(data => {
                            loadingIndicator.classList.remove('loading'); // Remove a classe após receber resposta da API
    
                            // loadingIndicator.style.display = 'none'; // Ocultar indicador após receber resposta da API
    
                            if (data.address) {
                                const address = `${data.address.road}, ${data.address.suburb}, ${data.address.city_district}, ${data.address.postcode}`;
                                document.getElementById('searchBar').value = address;
                                updateResults();
                            } else {
                                alert('Não foi possível determinar o endereço a partir da localização.');
                            }
                        })
                        .catch(error => {
                            loadingIcon.classList.remove('loading'); // Remove a classe em caso de erro ao obter a localização
                            console.error('Erro ao buscar endereço:', error);
                        });
                }, error => {
                    loadingIcon.classList.remove('loading'); // Remove a classe em caso de erro ao obter a localização
                    console.error('Erro ao obter localização:', error);
                    alert('Erro ao obter localização.');
                });
            } else {
                alert('Geolocalização não é suportada por este navegador.');
            }
        });  
        healthPlans.forEach(plan => {
            const pill = document.createElement('span');
            pill.className = 'pill';
            pill.textContent = plan;
            pill.onclick = () => togglePlanFilter(pill, plan);
            planFilters.appendChild(pill);
        });

        updateResults();
    }

    function togglePlanFilter(pill, plan) {
        const index = selectedPlans.indexOf(plan);
        if (index === -1) {
            selectedPlans.push(plan);
            pill.classList.add('selected');
        } else {
            selectedPlans.splice(index, 1);
            pill.classList.remove('selected');
        }
        updateResults();
    }
    // Add event listener to search bar
    

    
});